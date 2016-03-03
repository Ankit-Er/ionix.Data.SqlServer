package ionix.Data.SqlServer;

import ionix.Data.*;
import ionix.Data.EntitySqlQueryBuilderInsert;
import ionix.Utils.*;

import java.util.HashSet;


public class EntityCommandInsert<TEntity> extends ionix.Data.EntityCommandInsert<TEntity>  {

    public EntityCommandInsert(Class<TEntity> entityClass, DbAccess dataAccess) {
        super(entityClass, dataAccess);
    }


    @Override
    protected EntitySqlQueryBuilderInsert createInsertBuilder(){
        return new ionix.Data.SqlServer.EntitySqlQueryBuilderInsert();
    }
}
