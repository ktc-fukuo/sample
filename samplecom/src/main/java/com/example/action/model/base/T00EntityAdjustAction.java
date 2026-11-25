package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Entity;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * エンティティ更新
 *
 * @author emarfkrow
 */
public class T00EntityAdjustAction extends BaseAction {

    /** エンティティ更新処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object entityId = form.get("entityId");
        if (entityId == null) {
            entityId = form.get("T00Entity.entityId");
        }
        if (entityId == null) {
            throw new OptLockError("error.cant.adjust", "エンティティ");
        }

        T00Entity e = FormValidator.toBean(T00Entity.class.getName(), form);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.adjust", "エンティティ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.adjust"));
        return map;
    }

}
