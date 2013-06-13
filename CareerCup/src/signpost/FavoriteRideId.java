package signpost;

/**
 * 
SELECT rid.name, cnt.votes
FROM rides AS rid
  INNER JOIN
    (
	  SELECT favorite_ride_id, count(1) AS votes
	  FROM persons
	  GROUP BY favorite_rid_id
    ) AS cnt
        ON cnt.favorite_ride_id = rid.id
ORDER BY cnt.votes DESC  limit 10
 *
 */
public class FavoriteRideId {

}
