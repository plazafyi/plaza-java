// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SparqlQueryTest {

    @Test
    fun create() {
        val sparqlQuery =
            SparqlQuery.builder()
                .query(
                    "SELECT ?s ?name WHERE { ?s osm:name ?name . ?s osm:amenity \"cafe\" } LIMIT 10"
                )
                .build()

        assertThat(sparqlQuery.query())
            .isEqualTo(
                "SELECT ?s ?name WHERE { ?s osm:name ?name . ?s osm:amenity \"cafe\" } LIMIT 10"
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sparqlQuery =
            SparqlQuery.builder()
                .query(
                    "SELECT ?s ?name WHERE { ?s osm:name ?name . ?s osm:amenity \"cafe\" } LIMIT 10"
                )
                .build()

        val roundtrippedSparqlQuery =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sparqlQuery),
                jacksonTypeRef<SparqlQuery>(),
            )

        assertThat(roundtrippedSparqlQuery).isEqualTo(sparqlQuery)
    }
}
