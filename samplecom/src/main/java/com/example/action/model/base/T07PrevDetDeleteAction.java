package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07PrevDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 前世明細削除
 *
 * @author emarfkrow
 */
public class T07PrevDetDeleteAction extends BaseAction {

    /** 前世明細削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object prevId = postJson.get("prevId");
        if (prevId == null) {
            prevId = postJson.get("T07PrevDet.prevId");
        }
        if (prevId == null) {
            throw new OptLockError("error.cant.delete", "前世明細");
        }
        Object prevBn = postJson.get("prevBn");
        if (prevBn == null) {
            prevBn = postJson.get("T07PrevDet.prevBn");
        }
        if (prevBn == null) {
            throw new OptLockError("error.cant.delete", "前世明細");
        }

        T07PrevDet e = FormValidator.toBean(T07PrevDet.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "前世明細");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
