package com.student.model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends Product {
    private Category category;

}
