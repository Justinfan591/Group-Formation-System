package dataaccess;

import entities.Project;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Interface for project repository operations.
 * Defines methods for managing projects in the database.
 */
public interface IProjectRepository {

    /**
     * Creates a new project.
     *
     * @param title the title of the project
     * @param budget the budget of the project
     * @param description the description of the project
     * @param tags the tags associated with the project
     * @param embeddings the embeddings associated with the project
     * @param ownerId the user ID of the creator of the project.
     * @return the created project
     */
    Project createProject(String title, double budget, String description, HashSet<String> tags, float[] embeddings, int ownerId);

    /**
     * Deletes a project.
     *
     * @param projectId the id of the project to be deleted
     */
    boolean deleteProject(int projectId);

    /**
     * Gets a project by its id.
     *
     * @param projectId the id of the project
     * @return the project
     */
    Project getProjectById(int projectId);

    /**
     * Adds a set of tags to a project.
     *
     * @param projectId the id of the project to add the tags to.
     * @param tags a set of tags associated with the project.
     */
    boolean addTags(int projectId, HashSet<String> tags);

    /**
     * Removes a set of tags to a project.
     *
     * @param projectId the id of the project to add the tags to.
     * @param tags a set of tags to be removed.
     */
    boolean removeTags(int projectId, HashSet<String> tags);

    /**
     * Retrieves a set of projects that match the given keyword in their title, description, or tags.
     *
     * @param keyword the keyword to be matched
     * @return the set of projects
     */
    HashSet<Project> getProjectsByKeyword(String keyword);

    /**
     * Updates a project.
     *
     * @param id the id of the project
     * @param title the title of the project
     * @param budget the budget of the project
     * @param description the description of the project
     * @param tags the tags associated with the project
     * @param embeddings the embeddings associated with the project
     */
    boolean update(int id, String title, double budget, String description, HashSet<String> tags, float[] embeddings);

    /**
     * Retrieves all project embeddings from the database and returns them as a HashMap.
     * @return a hashmap where the keys are the project ids and the values are the embeddings
     */
    HashMap<Integer, float[]> getAllEmbeddings();

    /**
     * Retrieves the owner ID of a project from the database by its project ID.
     *
     * @param projectId The ID of the project whose owner ID is to be retrieved.
     * @return The ID of the user who owns the project, or -1 if the project is not found.
     */
    int getOwnerId(int projectId);
}