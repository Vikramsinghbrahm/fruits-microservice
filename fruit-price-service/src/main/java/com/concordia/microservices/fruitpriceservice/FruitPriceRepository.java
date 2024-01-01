package com.concordia.microservices.fruitpriceservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// JpaRepository provides CRUD operations for the FruitPrice entity with its unique identifier (id) as Long.
// JpaSpecificationExecutor allows for dynamic queries based on specifications.
public interface FruitPriceRepository extends JpaRepository<FruitPrice, Long> {

    // Custom query to find the fruit price based on the given fruit name and month.
    // The @Query annotation allows writing custom JPQL (Java Persistence Query Language) queries.
    @Query("SELECT " +
            "CASE " +
            "   WHEN LOWER(:month) = 'jan' THEN fp.jan " +
            "   WHEN LOWER(:month) = 'feb' THEN fp.feb " +
            "   WHEN LOWER(:month) = 'mar' THEN fp.mar " +
            "   WHEN LOWER(:month) = 'apr' THEN fp.apr " +
            "   WHEN LOWER(:month) = 'may' THEN fp.may " +
            "   WHEN LOWER(:month) = 'jun' THEN fp.jun " +
            "   WHEN LOWER(:month) = 'jul' THEN fp.jul " +
            "   WHEN LOWER(:month) = 'aug' THEN fp.aug " +
            "   WHEN LOWER(:month) = 'sep' THEN fp.sep " +
            "   WHEN LOWER(:month) = 'oct' THEN fp.oct " +
            "   WHEN LOWER(:month) = 'nov' THEN fp.nov " +
            "   WHEN LOWER(:month) = 'dec' THEN fp.dec " +
            "END AS fruitPrice " +
            "FROM FruitPrice fp " +
            "WHERE LOWER(fp.fruitName) = LOWER(:fruitName)")
    Double findFruitPriceByFruitNameAndMonth(@Param("fruitName") String fruitName, @Param("month") String month);

    // Custom query to find the unique identifier (id) for the given fruit name.
    @Query("SELECT fp.id FROM FruitPrice fp WHERE LOWER(fp.fruitName) = LOWER(:fruitName)")
    Long findIdByFruitName(@Param("fruitName") String fruitName);
}
