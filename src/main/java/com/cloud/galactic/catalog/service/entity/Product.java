package com.cloud.galactic.catalog.service.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Product
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-10T12:35:24.313769100+07:00[Asia/Saigon]")
@Data
@Builder
@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
@ToString
@Table(name = "product")
@Entity
public class Product implements Serializable {


  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "name", columnDefinition = "text", insertable =  false, updatable = false)
  private String name;


  @ElementCollection
  @CollectionTable(name = "Image", joinColumns =@JoinColumn(name = "productId"), uniqueConstraints = @UniqueConstraint(columnNames = {
          "productId", "image"
  }))
  @Column(name = "image")
  private Set<String> images;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "categoryId")
  private Category category;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "unitId")
  private Unit unit;

  /**
   * label for product
   */
  public enum LabelEnum {
    B_N_CH_Y("Bán chạy"),
    
    M_I("Mới");

    private String value;

    LabelEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LabelEnum fromValue(String value) {
      for (LabelEnum b : LabelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Enumerated(EnumType.STRING)
  private LabelEnum label;

  @ManyToOne
  @JoinColumn(name = "bundleId")
  private Bundle bundle;

  @Column(name = "name", columnDefinition = "text")
  private String description;

  @Column(name = "code")
  private Long code;

  @Column(name = "price")
  private Double price;

  @Column(name = "costPrice")
  private Double costPrice;

  @Column(name = "inventory")
  private BigDecimal inventory;

}

