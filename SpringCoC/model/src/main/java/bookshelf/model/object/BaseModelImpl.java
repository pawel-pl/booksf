package bookshelf.model.object;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author spike
 * 
 */
@MappedSuperclass
public abstract class BaseModelImpl implements BaseModel {

	private static final long serialVersionUID = 2929741808070164340L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {

		return hashCode(this);
	}

	public int hashCode(BaseModel model) {
		return new HashCodeBuilder().append(model.getId()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return equals(this, obj);
	}

	public static boolean equals(BaseModel thisObj, Object obj) {

		if (!thisObj.getClass().isInstance(obj)) {
			return false;
		}
		if (thisObj == obj) {
			return true;
		}

		BaseModel base = (BaseModel) obj;
		if (thisObj.getId() == null || base.getId() == null) {
			return false;
		}

		return thisObj.getId().equals(base.getId());
	}

	@Override
	public String toString() {

		return this.getId() != null ? this.getId().toString() : "";
	}

}
