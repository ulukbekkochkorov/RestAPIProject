package com.peaksoft.restapipractice.service;
import com.peaksoft.restapipractice.dto.company.CompanyRequest;
import com.peaksoft.restapipractice.dto.company.CompanyResponse;
import com.peaksoft.restapipractice.entity.Company;

import java.io.IOException;
import java.util.List;

public interface CompanyService {
    List<CompanyResponse> getAllCompanies();

    CompanyResponse addCompany(CompanyRequest companyRequest);

    CompanyResponse getCompanyById(Long id);

    CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest);

    CompanyResponse deleteCompany(Long companyId);
}
