package com.cloud.galactic.catalog.service.entity;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * CategoryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-13T21:37:08.246609700+07:00[Asia/Saigon]")
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "category")
@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "categoryid")
  private Integer categoryid;

  @NotNull(message = "Không để trống")
  @Size(max = 500, message = "Tối đa là 500 ký tự")
  @Column(name = "categoryName", columnDefinition = "text")
  private String categoryName;

  @Column(name = "parentCategoryId")
  private Integer parentCategoryId;

  @NotNull(message = "Không để trống")
  @Size(max = 5000, message = "Tối đa là 5000 ký tự")
  @Column(name = "description", columnDefinition = "text")
  private String description;

}

