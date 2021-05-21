import React, { useState } from 'react';
import { connect } from 'react-redux';
import './OrderItem.scss';
import Moment from 'react-moment';

import {formatMoney} from "../../pipes/priceFormatter";

const OrderItem = (
    {
        orderId,
        purchaseTime,
        description,
        amount,
        statusReadable,
        transactionId,
    }
) => {
    let time = purchaseTime / 1000;
    let formmatedMoney = formatMoney(amount)
    return (
        <div className="container">
            <div className="row">
                <div className="col-2">
                    {transactionId}
                </div>
                <div className="col-2">
                    <Moment unix format="DD/MM/YYYY">{time}</Moment>
                </div>
                <div className="col-4">
                    Lorem ipsum dolor
                </div>
                <div className="col-2">
                    {formmatedMoney}
                </div>
                <div className="col-2">
                    {statusReadable}
                </div>
            </div>
        </div>
    );
};

export default connect()(OrderItem);
