package me.upp.dali.service.request;

import lombok.Data;

@Data
public class GetImages {

    private final int amount;
    private final String category;

}
