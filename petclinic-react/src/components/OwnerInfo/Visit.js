import React from 'react'

const Visit = ({ description, date }) => {
    return (
        <tr>
            <td>{date}</td>
            <td>{description}</td>
        </tr>
    )
}

export default Visit