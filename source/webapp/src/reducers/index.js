import {combineReducers} from 'redux';
import shop from './shop.reducer';
import {brandFilterReducer} from "./brand.filter.reducer";
import {orderByPriceReducer} from "./orderByPrice.filter.reducer";
import {paginationReducer} from "./pagination.reducer";
import {orderReducer} from "./order.reducer";
import {paymentReducer} from "./payment.reducer";

export default combineReducers({
    shop,
    brandFilter: brandFilterReducer,
    orderBy: orderByPriceReducer,
    pagination: paginationReducer,
    orderReducer,
    paymentReducer
});
