package org.andrey.spring.service;

import lombok.RequiredArgsConstructor;
import org.andrey.spring.database.repository.CompanyRepository;
import org.andrey.spring.dto.CompanyReadDto;
import org.andrey.spring.listener.AccessType;
import org.andrey.spring.listener.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.getId());
                });
    }
}
