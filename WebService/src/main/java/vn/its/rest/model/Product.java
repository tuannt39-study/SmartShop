package vn.its.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	
		@Id
		@Column(name = "ID")
		private long id;
		
		@Column(name = "NAME")
		private String name;
		
		@Column(name = "PRICE")
		private long price;
		
		@Column(name = "IMAGE")
		private String image;
		
		@Column(name = "DESCRIPTION")
		private String description;
		
		@Column(name = "DISCOUNT")
		private String discount;
		
		@Column(name = "QUANTITY")
		private long quantity;
		
		@Column(name = "VIEWS")
		private long views;
		
		@Column(name = "STATUS")
		private String status;
		
		@Column(name = "CATEGORY_ID")
		private long categoryId;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDiscount() {
			return discount;
		}

		public void setDiscount(String discount) {
			this.discount = discount;
		}

		public long getQuantity() {
			return quantity;
		}

		public void setQuantity(long quantity) {
			this.quantity = quantity;
		}

		public long getViews() {
			return views;
		}

		public void setViews(long views) {
			this.views = views;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(long categoryId) {
			this.categoryId = categoryId;
		}

		public Product(long id, String name, long price, String image, String description, String discount,
				long quantity, long views, String status, long categoryId) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.image = image;
			this.description = description;
			this.discount = discount;
			this.quantity = quantity;
			this.views = views;
			this.status = status;
			this.categoryId = categoryId;
		}

		public Product() {
			super();
		}
	
}
