package com.peaksoft.restapipractice.service.impl;
import com.peaksoft.restapipractice.converter.company.CompanyRequestConverter;
import com.peaksoft.restapipractice.converter.company.CompanyResponseConverter;
import com.peaksoft.restapipractice.dto.company.CompanyRequest;
import com.peaksoft.restapipractice.dto.company.CompanyResponse;
import com.peaksoft.restapipractice.entity.Company;
import com.peaksoft.restapipractice.repository.CompanyRepository;
import com.peaksoft.restapipractice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final CompanyRequestConverter companyRequestConverter;
    private final CompanyResponseConverter companyResponseConverter;


    @Override
    public List<CompanyResponse> getAllCompanies() {
        return companyResponseConverter.view(repository.findAll());
    }

    @Override
    public CompanyResponse addCompany(CompanyRequest companyRequest) {
        Company company = companyRequestConverter.createCompany(companyRequest);
        repository.save(company);
        return companyResponseConverter.viewCompany(company);
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        Company company = repository.findById(id).get();
        return companyResponseConverter.viewCompany(company);

    }

    @Override
    public CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest) {
        Company company1 =  repository.findById(companyId).get();
        companyRequestConverter.updateCompany(company1, companyRequest);
        repository.save(company1);
        return companyResponseConverter.viewCompany(company1);

    }

    @Override
    public CompanyResponse deleteCompany(Long companyId) {
        Company company= repository.findById(companyId).get();
        repository.delete(company);
        return companyResponseConverter.viewCompany(company);


            }
        }
