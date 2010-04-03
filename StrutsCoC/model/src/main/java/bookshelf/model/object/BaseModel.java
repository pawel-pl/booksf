package bookshelf.model.object;

import java.io.Serializable;

/**
 * @author spike
 * 
 */
public interface BaseModel extends Serializable {

	public Long getId();

	public boolean equals(Object obj);

	public int hashCode();

	public String toString();

}
