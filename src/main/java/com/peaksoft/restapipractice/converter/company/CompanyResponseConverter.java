package com.peaksoft.restapipractice.converter.company;

import com.peaksoft.restapipractice.dto.company.CompanyResponse;
import com.peaksoft.restapipractice.entity.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyResponseConverter {
    public CompanyResponse viewCompany(Company company){
        if (company==null){
            return null;
        }
        CompanyResponse companyResponse = new CompanyResponse();

        companyResponse.setId(company.getId());
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        companyResponse.setCountOfStudent(company.getCountOfStudent());
        return companyResponse;
    }
    public List<CompanyResponse> view(List<Company> companies){
        List<CompanyResponse> companyResponses = new ArrayList<>();

        for (Company company : companies) {
            companyResponses.add(viewCompany(company));
        }
        return companyResponses;
    }
}
