package com.splashlearn.mas.cricket.models.cardAttributes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchesAttribute extends BaseCardAttribute {
    private String attributeName;
    private int attributeValue;
     public MatchesAttribute(String name, int value) {
        super(name, value); 
    }
}