package net.bakaar.sandbox.cas.infra.repository.springdata;

import net.bakaar.sandbox.cas.domain.Case;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pnummer;
    private String businessId;

    public static CaseEntity fromCase(Case aCase) {
        return new CaseEntity()
                .setPnummer(aCase.getPnummer())
                .setBusinessId(aCase.getId());
    }

    public String getPnummer() {
        return pnummer;
    }

    public CaseEntity setPnummer(String pnummer) {
        this.pnummer = pnummer;
        return this;
    }

    public String getBusinessId() {
        return businessId;
    }

    public CaseEntity setBusinessId(String businessId) {
        this.businessId = businessId;
        return this;
    }

    public Case toCase() {
        return new Case(this.businessId, this.getPnummer());
    }
}
