package de.fred4jupiter.springdatajpaauditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component("auditorAware")
public class AuditorAwareImpl implements AuditorAware<AppUser> {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public Optional<AppUser> getCurrentAuditor() {
        AppUser appUser = appUserRepository.findByUsername("fred");
        return Optional.of(appUser);

        // in production you will use:
        // SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
    }
}
