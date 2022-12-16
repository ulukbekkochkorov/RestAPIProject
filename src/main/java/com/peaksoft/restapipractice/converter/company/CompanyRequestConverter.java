package com.peaksoft.restapipractice.converter.company;

import com.peaksoft.restapipractice.dto.company.CompanyRequest;
import com.peaksoft.restapipractice.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyRequestConverter {
    public Company createCompany(CompanyRequest companyRequest){
        if (companyRequest == null){
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }
    public void updateCompany(Company company, CompanyRequest companyRequest){
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(company.getLocatedCountry());
    }
}
