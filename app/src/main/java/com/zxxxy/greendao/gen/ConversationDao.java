package com.zxxxy.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.zxxxy.coolarithmetic.entity.Conversation;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "CONVERSATION".
 */
public class ConversationDao extends AbstractDao<Conversation, Long> {

    public static final String TABLENAME = "CONVERSATION";

    /**
     * Properties of entity Conversation.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property UnReadNum = new Property(1, int.class, "unReadNum", false, "UN_READ_NUM");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public final static Property Type = new Property(4, String.class, "type", false, "TYPE");
        public final static Property Avatar = new Property(5, String.class, "avatar", false, "AVATAR");
        public final static Property Remark = new Property(6, String.class, "remark", false, "REMARK");
        public final static Property Time = new Property(7, long.class, "time", false, "TIME");
    }


    public ConversationDao(DaoConfig config) {
        super(config);
    }

    public ConversationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONVERSATION\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"UN_READ_NUM\" INTEGER NOT NULL ," + // 1: unReadNum
                "\"NAME\" TEXT," + // 2: name
                "\"CONTENT\" TEXT," + // 3: content
                "\"TYPE\" TEXT," + // 4: type
                "\"AVATAR\" TEXT," + // 5: avatar
                "\"REMARK\" TEXT," + // 6: remark
                "\"TIME\" INTEGER NOT NULL );"); // 7: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONVERSATION\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Conversation entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getUnReadNum());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(5, type);
        }
 
        String avatar = entity.getAvatar();
        if (avatar != null) {
            stmt.bindString(6, avatar);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(7, remark);
        }
        stmt.bindLong(8, entity.getTime());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Conversation entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getUnReadNum());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(5, type);
        }
 
        String avatar = entity.getAvatar();
        if (avatar != null) {
            stmt.bindString(6, avatar);
        }
 
        String remark = entity.getRemark();
        if (remark != null) {
            stmt.bindString(7, remark);
        }
        stmt.bindLong(8, entity.getTime());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Conversation readEntity(Cursor cursor, int offset) {
        Conversation entity = new Conversation( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.getInt(offset + 1), // unReadNum
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // content
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // type
                cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // avatar
                cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // remark
                cursor.getLong(offset + 7) // time
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Conversation entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUnReadNum(cursor.getInt(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setType(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAvatar(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRemark(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setTime(cursor.getLong(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Conversation entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Conversation entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Conversation entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
