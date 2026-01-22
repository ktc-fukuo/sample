package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Prev;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 前世削除
 *
 * @author emarfkrow
 */
public class Tb6PrevDeleteAction extends BaseAction {

    /** 前世削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object prevId = postJson.get("prevId");
        if (prevId == null) {
            prevId = postJson.get("Tb6Prev.prevId");
        }
        if (prevId == null) {
            throw new OptLockError("error.cant.delete", "前世");
        }

        Tb6Prev e = FormValidator.toBean(Tb6Prev.class.getName(), postJson);

        java.util.List<com.example.entity.Tb6PrevDet> tb6PrevDets = e.referTb6PrevDets();
        if (tb6PrevDets != null) {
            for (com.example.entity.Tb6PrevDet tb6PrevDet : tb6PrevDets) {

                if (tb6PrevDet.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "前世明細");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "前世");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
