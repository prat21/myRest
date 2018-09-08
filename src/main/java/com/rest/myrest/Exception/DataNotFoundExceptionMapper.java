package com.rest.myrest.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rest.myrest.model.ExceptionModel;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		return Response.status(Status.NOT_FOUND)
				.entity(new ExceptionModel(exception.getMessage(),404))
				.build();
	}

}
