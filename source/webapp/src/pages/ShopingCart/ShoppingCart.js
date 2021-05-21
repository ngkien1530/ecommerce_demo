import React from 'react';
import { connect } from 'react-redux';
import { formatMoney } from "../../pipes/priceFormatter";
import CartItem from "../../components/CartItem/CartItem";
import { makePayment } from '../../actions';
import { moment } from 'react-moment';

const ShoppingCart = (props) => {
    const makePayment = () => {
        let products = props.cartItems.map(function (item) {
            return {
                name: item.title,
                price: item.price,
                description: item.description,
                quantity: item.quantity,
            }
        });
        let purchaseTime = "2021-05-21T11:39:31.130Z";
        let paymentDetail = {
            amount: props.totalPrice,
            method: 'CREDIT_CARD',
            userId: '1',
            purchaseTime,
            paymentCardId: '1',
            orderInfo: {
                total: props.cartItemCount,
                products
            }
        }
        console.log('payment detail: ', paymentDetail);
        props.onMakePayment(paymentDetail)
    }

    return (
        <>
            <div className="container" style={{ paddingTop: '6rem' }}>
                <div className="card shopping-cart">
                    <div className="card-header bg-dark text-light">
                        <i className="fa fa-shopping-cart pr-2" aria-hidden="true"></i>
                            Shipping cart
                            <div className="clearfix"></div>
                    </div>
                    <div className="card-body">
                        {props.cartItemCount ? props.cartItems.map(cart => (
                            <CartItem {...cart} img={cart.images[0]} />
                        )) : <h1 className="display-4 mt-5 text-center">There is no product in your cart</h1>}
                    </div>
                    <div className="card-footer">
                        <div className="pull-right" style={{ margin: '10px' }}>
                            <div className="pull-right" style={{ margin: '5px' }}>
                                <div>Total price: <b>{formatMoney(props.totalPrice)}€</b></div>
                                {((props.paymentRes == null || props.paymentRes == undefined) && props.cartItemCount > 0) ? 
                                    <div>
                                        <div style={{margin: 5}}>Pay with: <b>VISA</b></div>
                                        <button className="btn btn-info pull-right"
                                            onClick={makePayment}>Confirm Payment</button>
                                    </div>
                                    :
                                    null }
                                {props.paymentRes == true ? <div><b>Payment Successful!</b></div> : null}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};

const mapStateToProps = state => {

    console.log(state, 'state has changed');

    return {
        cartItems: state.shop.cart,
        cartItemCount: state.shop.cart.reduce((count, curItem) => {
            return count + curItem.quantity;
        }, 0),
        totalPrice: state.shop.cart.reduce((count, curItem) => {
            return count + (curItem.price * curItem.quantity);
        }, 0),
        paymentRes: state.paymentReducer.paymentRes
    }
}

const mapDispatchToProps = dispatch => ({
    onMakePayment: paymentDetail => dispatch(makePayment('VISA', paymentDetail))
})

export default connect(mapStateToProps, mapDispatchToProps)(ShoppingCart);
