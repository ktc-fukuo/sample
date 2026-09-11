package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生１削除
 *
 * @author emarfkrow
 */
public class T07Derive1DeleteAction extends BaseAction {

    /** 派生１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object derive1Id = form.get("derive1Id");
        if (derive1Id == null) {
            derive1Id = form.get("T07Derive1.derive1Id");
        }
        if (derive1Id == null) {
            throw new OptLockError("error.cant.delete", "派生１");
        }

        T07Derive1 e = FormValidator.toBean(T07Derive1.class.getName(), form);

        // 子：派生１明細を全て指定済みか確認
        int orgT07Derive1DetsSize = e.getT07Derive1Dets().size();
        if (e.referT07Derive1Dets().size() != orgT07Derive1DetsSize) {
            throw new OptLockError("error.cant.delete", "派生１明細");
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "派生１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
