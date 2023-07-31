const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {
	constructor(props) {
		super(props);
		this.state = {singers: []};
	}
	componentDidMount() {
		client({method: 'GET', path: '/api/singers'}).done(response => {
			this.setState({singers: response.entity._embedded.singers});
		});
	}
	render() {
		return (
			<SingersList singers={this.state.singers}/>
		)
	}
}

class SingersList extends React.Component{
	render() {
		const singers = this.props.singers.map(singers =>
			<Singers key={singers._links.self.href} singers={singers}/>
		);
		return (
			<table border="1">
				<tbody>
					<tr>
						<th>Name</th>
						<th>Band</th>
						<th>Song</th>
					</tr>
					{singers}
				</tbody>
			</table>
		)
	}
}

class Singers extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.singers.name}</td>
				<td>{this.props.singers.band}</td>
				<td>{this.props.singers.song}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)