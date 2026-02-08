package com.aeo.framework.model.order;

import lombok.Data;

import java.util.List;

@Data
public class Items {

    private List<Item> item;

    private int lineCollectionSize;

}
