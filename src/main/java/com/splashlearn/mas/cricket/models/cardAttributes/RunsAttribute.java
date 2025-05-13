package com.splashlearn.mas.cricket.models.cardAttributes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RunsAttribute implements ICardAttribute {
    private String attributeName;
    private int attributeValue;
}