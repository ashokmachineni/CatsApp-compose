package com.ashoks.catsapp.network.model

import com.ashoks.catsapp.domain.model.Cats
import com.ashoks.catsapp.domain.util.DomainMapper

class CatsDtoMapper : DomainMapper<CatsDto, Cats> {

    override fun mapToDomainModel(model: CatsDto): Cats {
        return Cats(
            id = model.id,
            name = model.name,
            temperament = model.temperament,
            energy_level = model.energy_level,
            wikipedia_url = model.wikipedia_url,
            reference_image_id = model.reference_image_id,
        )
    }

    override fun mapFromDomainModel(domainModel: Cats): CatsDto {
        return CatsDto(
            id = domainModel.id,
            name = domainModel.name,
            temperament = domainModel.temperament,
            energy_level = domainModel.energy_level,
            wikipedia_url = domainModel.wikipedia_url,
            reference_image_id = domainModel.reference_image_id,
        )
    }

    fun toDomainList(initial: List<CatsDto>): List<Cats>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Cats>): List<CatsDto>{
        return initial.map { mapFromDomainModel(it) }
    }


}