import Moment from 'react-moment';

export const convertTimestampToDate = timestamp => {
    let t = new Date(timestamp);
    return t.format("dd.mm.yyyy hh:MM:ss");
}