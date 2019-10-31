package com.redhat.appdev.todolist;

import com.redhat.appdev.todolist.beans.Todo;
import java.lang.String;
import java.util.List;
import java.util.concurrent.CompletionStage;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/todos")
public interface TodosResource {
  /**
   * Gets a list of all `Todo` entities.
   */
  @GET
  @Produces("application/json")
  CompletionStage<List<Todo>> gettodos();

  /**
   * Creates a new instance of a `Todo`.
   */
  @POST
  @Consumes("application/json")
  void createTodo(Todo data);

  /**
   * Gets the details of a single instance of a `Todo`.
   */
  @Path("/{todoId}")
  @GET
  @Produces("application/json")
  CompletionStage<Todo> getTodo(@PathParam("todoId") String todoId);

  /**
   * Updates an existing `Todo`.
   */
  @Path("/{todoId}")
  @PUT
  @Consumes("application/json")
  void updateTodo(@PathParam("todoId") String todoId, Todo data);

  /**
   * Deletes an existing `Todo`.
   */
  @Path("/{todoId}")
  @DELETE
  void deleteTodo(@PathParam("todoId") String todoId);
}
