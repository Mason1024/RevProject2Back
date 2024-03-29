package org.stuff.entities;

import javax.persistence.*;

@Entity
@Table(name = "posting")
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int id;

    @JoinColumn(name = "u_id")
    @ManyToOne
    private User user; 

    @Column(name = "title")
    private String title;

    @Column (name = "description")
    private String description;

    @Column (name = "category")
    private String category;

    @Column (name = "location")
    private String location;

    @Column (name = "init_date")
    private long initDate;

    @Column (name = "end_date")
    private long endDate;

    @Column (name = "img")
    private String img;

    public Posting() { }

	public Posting(int id, User user, String title, String description, String category, String location, long initDate,
			long endDate, String img) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.description = description;
		this.category = category;
		this.location = location;
		this.initDate = initDate;
		this.endDate = endDate;
		this.img = img;
	}
	
	public Posting(WebPosting posting) {
		super();
		this.id = posting.getId();
		this.user = new User(posting.getUser());
		this.title = posting.getTitle();
		this.description = posting.getDescription();
		this.category = posting.getCategory();
		this.location = posting.getLocation();
		this.initDate = posting.getInitDate();
		this.endDate = posting.getEndDate();
		this.img = posting.getImg();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getInitDate() {
		return initDate;
	}

	public void setInitDate(long initDate) {
		this.initDate = initDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Posting [id=" + id + ", user=" + user.getId() + ", title=" + title + ", description=" + description
				+ ", category=" + category + ", location=" + location + ", initDate=" + initDate + ", endDate="
				+ endDate + ", img=" + img + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (endDate ^ (endDate >>> 32));
		result = prime * result + id;
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + (int) (initDate ^ (initDate >>> 32));
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.getId());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posting other = (Posting) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate != other.endDate)
			return false;
		if (id != other.id)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (initDate != other.initDate)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (user.getId()!=other.user.getId())
			return false;
		return true;
	}   

}
