package core.ejb.model;

import java.io.Serializable;

public class QueryResult implements Serializable {

    private static final long serialVersionUID = -7077714295316702916L;

    private Object param1;
    private Object param2;
    private Object param3;
    private Object param4;

    public QueryResult(Object param1, Object param2, Object param3,
	    Object param4) {

	this.param1 = param1;
	this.param2 = param2;
	this.param3 = param3;
	this.param4 = param4;
    }

    @Override
    public String toString() {
	return "QueryResult [param1=" + param1 + ", param2=" + param2
		+ ", param3=" + param3 + ", param4=" + param4 + "]";
    }

}
