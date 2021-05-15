import {LOAD_ORDERS, LOAD_ORDERS_FAILED, LOAD_ORDERS_SUCCESS} from "../actions";

const initialState = {
    loading: false,
    error: null,
    orders: []
};

export const orderReducer = (state = initialState, action) => {
    console.log('action changed: ', action)
    switch (action.type) {
        case LOAD_ORDERS:
            return {
                loading: true,
                ...state
            };
        case LOAD_ORDERS_SUCCESS:
            return {
                ...state,
                loading: false,
                orders: action.payload.orders,
                error: null
            };
        case LOAD_ORDERS_FAILED:
            return {
                ...state,
                loading: false,
                error: action.payload.error
            };
        default:
            return state;
    }
};

export default orderReducer;
