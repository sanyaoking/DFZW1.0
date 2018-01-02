package com.mengchaob.util;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class DBUtil {
//    private
    private static SqlSession sqs=MybatisInit.getSqs();

    /**
     * Retrieve a single row mapped from the statement key
     * @param <T> the returned object type
     * @param statement
     * @return Mapped object
     */
    public static <T> T  selectOne(String statement){
        return sqs.selectOne(statement);
    }

    /**
     * Retrieve a single row mapped from the statement key and parameter.
     * @param <T> the returned object type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return Mapped object
     */
    public static <T> T selectOne(String statement, Object parameter) {
        return sqs.selectOne(statement,parameter);
    }

    /**
     * Retrieve a list of mapped objects from the statement key and parameter.
     * @param <E> the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @return List of mapped object
     */
    public static <E> List<E> selectList(String statement){
        return sqs.selectList(statement);
    }

    /**
     * Retrieve a list of mapped objects from the statement key and parameter.
     * @param <E> the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return List of mapped object
     */
    public static <E> List<E> selectList(String statement, Object parameter){
        return sqs.selectList( statement,  parameter);
    }

    /**
     * Retrieve a list of mapped objects from the statement key and parameter,
     * within the specified row bounds.
     * @param <E> the returned list element type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param rowBounds  Bounds to limit object retrieval
     * @return List of mapped object
     */
    public static  <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds){
        return selectList(statement, parameter,rowBounds);
    }

    /**
     * The selectMap is a special case in that it is designed to convert a list
     * of results into a Map based on one of the properties in the resulting
     * objects.
     * Eg. Return a of Map[Integer,Author] for selectMap("selectAuthors","id")
     * @param <K> the returned Map keys type
     * @param <V> the returned Map values type
     * @param statement Unique identifier matching the statement to use.
     * @param mapKey The property to use as key for each value in the list.
     * @return Map containing key pair data.
     */
    public static <K, V> Map<K, V> selectMap(String statement, String mapKey){
        return sqs.selectMap(statement,mapKey);
    }

    /**
     * The selectMap is a special case in that it is designed to convert a list
     * of results into a Map based on one of the properties in the resulting
     * objects.
     * @param <K> the returned Map keys type
     * @param <V> the returned Map values type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param mapKey The property to use as key for each value in the list.
     * @return Map containing key pair data.
     */
    public static <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey){
        return sqs.selectMap(statement,parameter,mapKey);
    }

    /**
     * The selectMap is a special case in that it is designed to convert a list
     * of results into a Map based on one of the properties in the resulting
     * objects.
     * @param <K> the returned Map keys type
     * @param <V> the returned Map values type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param mapKey The property to use as key for each value in the list.
     * @param rowBounds  Bounds to limit object retrieval
     * @return Map containing key pair data.
     */
    public static  <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds){
        return sqs.selectMap(statement,parameter, mapKey,rowBounds);
    }

    /**
     * A Cursor offers the same results as a List, except it fetches data lazily using an Iterator.
     * @param <T> the returned cursor element type.
     * @param statement Unique identifier matching the statement to use.
     * @return Cursor of mapped objects
     */
    public static <T> Cursor<T> selectCursor(String statement){
        return sqs.selectCursor(statement);
    }

    /**
     * A Cursor offers the same results as a List, except it fetches data lazily using an Iterator.
     * @param <T> the returned cursor element type.
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return Cursor of mapped objects
     */
    public static <T> Cursor<T> selectCursor(String statement, Object parameter){
        return sqs.selectCursor(statement,parameter);
    }

    /**
     * A Cursor offers the same results as a List, except it fetches data lazily using an Iterator.
     * @param <T> the returned cursor element type.
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param rowBounds  Bounds to limit object retrieval
     * @return Cursor of mapped objects
     */
    public static <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds){
        return sqs.selectCursor(statement,parameter,rowBounds);
    }

    /**
     * Retrieve a single row mapped from the statement key and parameter
     * using a {@code ResultHandler}.
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @param handler ResultHandler that will handle each retrieved row
     */
    public static void select(String statement, Object parameter, ResultHandler handler){
        sqs.select(statement,parameter,handler);
    }

    /**
     * Retrieve a single row mapped from the statement
     * using a {@code ResultHandler}.
     * @param statement Unique identifier matching the statement to use.
     * @param handler ResultHandler that will handle each retrieved row
     */
    public static void select(String statement, ResultHandler handler){
        sqs.select(statement,handler);
    }

    /**
     * Retrieve a single row mapped from the statement key and parameter
     * using a {@code ResultHandler} and {@code RowBounds}
     * @param statement Unique identifier matching the statement to use.
     * @param rowBounds RowBound instance to limit the query results
     * @param handler ResultHandler that will handle each retrieved row
     */
    public static void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler){
        sqs.select(statement,parameter,rowBounds,handler);
    }

    /**
     * Execute an insert statement.
     * @param statement Unique identifier matching the statement to execute.
     * @return int The number of rows affected by the insert.
     */
    public static int insert(String statement){
        return sqs.insert(statement);
    }

    /**
     * Execute an insert statement with the given parameter object. Any generated
     * autoincrement values or selectKey entries will modify the given parameter
     * object properties. Only the number of rows affected will be returned.
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return int The number of rows affected by the insert.
     */
    public static int insert(String statement, Object parameter){
        return sqs.insert(statement,parameter);
    }

    /**
     * Execute an insert statement with the given parameter object. Any generated
     * autoincrement values or selectKey entries will modify the given parameter
     * object properties.
     * @param statement
     * @param parameter
     * @param handler
     */
    public static void insert(String statement, Object parameter,Handler<Future<JsonObject>> handler){
        int i = sqs.insert(statement,parameter);
        JsonObject jb = new JsonObject();
        jb.put("result",i);
        handler.handle(Future.succeededFuture(jb));

    }

    /**
     * Execute an update statement. The number of rows affected will be returned.
     * @param statement Unique identifier matching the statement to execute.
     * @return int The number of rows affected by the update.
     */
    public static int update(String statement){
        return sqs.update(statement);
    }

    /**
     * Execute an update statement. The number of rows affected will be returned.
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return int The number of rows affected by the update.
     */
    public static int update(String statement, Object parameter){
        return sqs.update(statement,parameter);
    }

    /**
     * Execute a delete statement. The number of rows affected will be returned.
     * @param statement Unique identifier matching the statement to execute.
     * @return int The number of rows affected by the delete.
     */
    public static int delete(String statement){
        return sqs.delete(statement);
    }

    /**
     * Execute a delete statement. The number of rows affected will be returned.
     * @param statement Unique identifier matching the statement to execute.
     * @param parameter A parameter object to pass to the statement.
     * @return int The number of rows affected by the delete.
     */
    public static int delete(String statement, Object parameter){
        return sqs.delete(statement,parameter);
    }

}
