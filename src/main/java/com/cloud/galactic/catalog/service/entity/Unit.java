package com.cloud.galactic.catalog.service.entity;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Unit
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-10T12:35:24.313769100+07:00[Asia/Saigon]")
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "unit")
@Entity
public class Unit implements Serializable {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "name", columnDefinition = "text")
  private String name;

  @Column(name = "conversionUnit", columnDefinition = "text")
  private String conversionUnit;
}

