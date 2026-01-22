/**
 * CDマスタグリッド定義
 */

let Mb4CdGridColumns = [];

$(function() {
    Mb4CdGridColumns = [
        Column.text('CDREF_CD', Messages['Mb4CdGrid.cdrefCd'], 90, 'primaryKey', null),
        Column.text('CDREF_MEI', Messages['Mb4CdGrid.cdrefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Mb4CdGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
