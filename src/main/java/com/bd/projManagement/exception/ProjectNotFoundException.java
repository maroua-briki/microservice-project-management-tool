package com.bd.projManagement.exception;

public class ProjectNotFoundException extends RuntimeException {
	 public ProjectNotFoundException(int id) {
	        super(String.format("No poject entry found with id: <%s>", id));
	    }

}
