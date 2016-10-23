package net.downthehall.business.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: joseph
 * Date: 11/14/13
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollectionNames implements Serializable
{
    private static final long serialVersionUID = -3311655072265078399L;

    int collection_id;
    String collection_name;
    int country_id;
    String comments;

    public CollectionNames()
    {
    }

    public CollectionNames(int collection_id, String collection_name, int country_id, String comments)
    {
        this.collection_id = collection_id;
        this.collection_name = collection_name;
        this.country_id = country_id;
        this.comments = comments;
    }

    public int getCollection_id()
    {
        return collection_id;
    }

    public void setCollection_id(int collection_id)
    {
        this.collection_id = collection_id;
    }

    public String getCollection_name()
    {
        return collection_name;
    }

    public void setCollection_name(String collection_name)
    {
        this.collection_name = collection_name;
    }

    public int getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(int country_id)
    {
        this.country_id = country_id;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    @Override
    public String toString()
    {
        return "CollectionNames{" +
               "collection_id=" + collection_id +
               ", collection_name='" + collection_name + '\'' +
               ", country_id=" + country_id +
               ", comments='" + comments + '\'' +
               '}';
    }
}
