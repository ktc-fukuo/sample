/**
 * CDマスタグリッド定義
 */

let Mb4CdGridColumns = [];

$(function() {
    Mb4CdGridColumns = [
        Column.text('REF_CD', Messages['Mb4CdGrid.refCd'], 90, 'primaryKey', null),
        Column.text('REF_MEI', Messages['Mb4CdGrid.refMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Mb4CdGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
