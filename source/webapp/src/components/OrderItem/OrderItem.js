import React, { useState } from 'react';
import { connect } from 'react-redux';
import { shortenTitle } from "../../pipes/shortenTitle";
import { formatMoney } from "../../pipes/priceFormatter";
import './OrderItem.scss';
import { addProductToCart, decrementCartQuantity, incrementCartQuantity, removeProductToCart } from "../../actions";

const OrderItem = (
    {
        orderId,
        purchaseTime,
        description,
        amount,
        status,
        transactionId,
    }
) => {
    console.log(orderId);

    return (
        <div className="container">
            <div className="row">
                <div className="col-sm">
                    {transactionId}
                </div>
                <div className="col-sm">
                    {purchaseTime}
                </div>
                <div className="col-5">
                    {description}
                </div>
                <div className="col-sm">
                    {amount}
                </div>
                <div className="col-sm">
                    {status}
                </div>
            </div>
        </div>
    );
};

export default connect()(OrderItem);
