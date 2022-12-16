package com.peaksoft.restapipractice.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {
    private String companyName;
    private String locatedCountry;
}
