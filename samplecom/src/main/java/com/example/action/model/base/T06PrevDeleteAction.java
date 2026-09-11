package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06Prev;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 前世削除
 *
 * @author emarfkrow
 */
public class T06PrevDeleteAction extends BaseAction {

    /** 前世削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object prevId = form.get("prevId");
        if (prevId == null) {
            prevId = form.get("T06Prev.prevId");
        }
        if (prevId == null) {
            throw new OptLockError("error.cant.delete", "前世");
        }

        T06Prev e = FormValidator.toBean(T06Prev.class.getName(), form);

        // 子：前世明細を全て指定済みか確認
        int orgT06PrevDetsSize = e.getT06PrevDets().size();
        if (e.referT06PrevDets().size() != orgT06PrevDetsSize) {
            throw new OptLockError("error.cant.delete", "前世明細");
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "前世");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
