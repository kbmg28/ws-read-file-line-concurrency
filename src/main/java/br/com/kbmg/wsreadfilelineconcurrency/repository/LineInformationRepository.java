package br.com.kbmg.wsreadfilelineconcurrency.repository;

import br.com.kbmg.wsreadfilelineconcurrency.model.LineInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineInformationRepository extends JpaRepository<LineInformation, Integer> {
}
