package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生２削除
 *
 * @author emarfkrow
 */
public class T07Derive2DeleteAction extends BaseAction {

    /** 派生２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object derive2Id = form.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = form.get("T07Derive2.derive2Id");
        }
        if (derive2Id == null) {
            throw new OptLockError("error.cant.delete", "派生２");
        }

        T07Derive2 e = FormValidator.toBean(T07Derive2.class.getName(), form);

        // 子：派生２明細を全て指定済みか確認
        int orgT07Derive2DetsSize = e.getT07Derive2Dets().size();
        if (e.referT07Derive2Dets().size() != orgT07Derive2DetsSize) {
            throw new OptLockError("error.cant.delete", "派生２明細");
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "派生２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
