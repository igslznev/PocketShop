package com.respire.pocketshop.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "salescount")
    private Long salescount;

    @Column(name = "imageurl")
    private String imageurl;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "ratingcount")
    private Long ratingcount;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Feedback> feedbacks = new HashSet<>();

    @ManyToOne
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public Product price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getSalescount() {
        return salescount;
    }

    public Product salescount(Long salescount) {
        this.salescount = salescount;
        return this;
    }

    public void setSalescount(Long salescount) {
        this.salescount = salescount;
    }

    public String getImageurl() {
        return imageurl;
    }

    public Product imageurl(String imageurl) {
        this.imageurl = imageurl;
        return this;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDescription() {
        return description;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public Product rating(Double rating) {
        this.rating = rating;
        return this;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getRatingcount() {
        return ratingcount;
    }

    public Product ratingcount(Long ratingcount) {
        this.ratingcount = ratingcount;
        return this;
    }

    public void setRatingcount(Long ratingcount) {
        this.ratingcount = ratingcount;
    }

    public Set<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public Product feedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
        return this;
    }

    public Product addFeedbacks(Feedback feedback) {
        this.feedbacks.add(feedback);
        feedback.setProduct(this);
        return this;
    }

    public Product removeFeedbacks(Feedback feedback) {
        this.feedbacks.remove(feedback);
        feedback.setProduct(null);
        return this;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Category getCategory() {
        return category;
    }

    public Product category(Category category) {
        this.category = category;
        return this;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        if (product.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", salescount='" + getSalescount() + "'" +
            ", imageurl='" + getImageurl() + "'" +
            ", description='" + getDescription() + "'" +
            ", rating='" + getRating() + "'" +
            ", ratingcount='" + getRatingcount() + "'" +
            "}";
    }
}
