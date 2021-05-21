import {MAKE_PAYMENT, MAKE_PAYMENT_FAILED, MAKE_PAYMENT_SUCCESS} from "../actions";

const initialState = {
    loading: false,
    error: null,
    paymentRes: null
};

export const paymentReducer = (state = initialState, action) => {
    console.log('action changed: ', action)
    switch (action.type) {
        case MAKE_PAYMENT:
            return {
                loading: true,
                ...state
            };
        case MAKE_PAYMENT_SUCCESS:
            return {
                ...state,
                loading: false,
                paymentRes: action.payload.res,
                error: null
            };
        case MAKE_PAYMENT_FAILED:
            return {
                ...state,
                loading: false,
                error: action.payload.error
            };
        default:
            return state;
    }
};

export default paymentReducer;
